package com.example.surf.top_bars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surf.R
import com.example.surf.ui.theme.Black
import com.example.surf.ui.theme.Gray
import com.example.surf.ui.theme.LightGray
import com.example.surf.ui.theme.SurfTheme
import com.example.surf.ui.theme.White
import com.example.surf.ui.theme.robotoFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    focusManager: FocusManager,
    value: String,
    onValueChange: (String) -> Unit,
    sendRequest: (String) -> Unit,
    eraseSearchValue: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        BasicTextField(
            value = value,
            onValueChange = {onValueChange(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(36.dp),
            decorationBox = {innerTextField->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = LightGray,
                        focusedContainerColor = LightGray,
                        errorContainerColor = LightGray,
                        disabledContainerColor = LightGray,
                        errorLeadingIconColor = Gray,
                        disabledLeadingIconColor = Gray,
                        focusedLeadingIconColor = Gray,
                        unfocusedLeadingIconColor = Gray,
                        errorIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Black,
                        errorCursorColor = Black,
                        unfocusedPlaceholderColor = Gray,
                        errorPlaceholderColor = Gray,
                        disabledPlaceholderColor = Gray,
                        focusedPlaceholderColor = Gray,
                        errorTextColor = Black,
                        focusedTextColor = Black,
                        disabledTextColor = Black,
                        unfocusedTextColor = Black,
                        errorTrailingIconColor = Gray,
                        focusedTrailingIconColor = Gray,
                        disabledTrailingIconColor = Gray,
                        unfocusedTrailingIconColor = Gray
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.search_icon),
                            modifier = Modifier.size(24.dp),
                            contentDescription = null
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.search_placeholder),
                            color = Gray,
                            fontSize = 16.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.W400
                        )
                    },
                    trailingIcon = {
                        if(!value.isEmpty()) {
                            Icon(
                                painter = painterResource(R.drawable.delete_trailing_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable(
                                        onClick = {
                                            eraseSearchValue()
                                        }
                                    )
                            )
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(0.dp)
                )
            },
            keyboardOptions = KeyboardOptions.Default
                .copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions (
                onNext = {
                    focusManager.clearFocus()
                    sendRequest(value)
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchTopBarPreview() {
    SurfTheme {
       /*SearchTopBar(
           LocalFocusManager.current,
           value = "",
           onValueChange = {}
       )*/
    }
}